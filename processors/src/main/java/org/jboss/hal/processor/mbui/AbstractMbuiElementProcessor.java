/*
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.hal.processor.mbui;

import java.util.List;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;

import com.google.auto.common.MoreTypes;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 * @author Harald Pehl
 */
@SuppressWarnings("HardCodedStringLiteral")
abstract class AbstractMbuiElementProcessor implements MbuiElementProcessor {

    private final Types typeUtils;
    final MbuiViewProcessor processor;
    final XPathFactory xPathFactory;

    AbstractMbuiElementProcessor(final MbuiViewProcessor processor, final Types typeUtils,
            final XPathFactory xPathFactory) {
        this.processor = processor;
        this.typeUtils = typeUtils;
        this.xPathFactory = xPathFactory;
    }

    MetadataInfo findMetadata(final VariableElement field, final org.jdom2.Element element,
            final MbuiViewContext context) {
        MetadataInfo metadataInfo = null;
        XPathExpression<Element> expression = xPathFactory.compile("ancestor::metadata", Filters.element());
        org.jdom2.Element metadataElement = expression.evaluateFirst(element);
        if (metadataElement == null) {
            processor.error(field,
                    "Missing metadata ancestor for %s#%s. Please make sure the there's a <%s/> ancestor element.",
                    element.getName(), element.getAttributeValue("id"), XmlTags.METADATA);
        } else {
            metadataInfo = context.getMetadataInfo(metadataElement.getAttributeValue("address"));
            if (metadataInfo == null) {
                processor
                        .error(field, "No metadata found for %s#%s. Please make sure there's a <%s/> ancestor element.",
                                element.getName(), element.getAttributeValue("id"), XmlTags.METADATA);
            }
        }
        return metadataInfo;
    }

    String getTypeParameter(final VariableElement field) {
        String typeArgument = "org.jboss.hal.dmr.ModelNode";
        DeclaredType declaredType = MoreTypes.asDeclared(field.asType());
        List<? extends TypeMirror> typeArguments = declaredType.getTypeArguments();
        if (!typeArguments.isEmpty()) {
            typeArgument = MoreTypes.asTypeElement(typeUtils, typeArguments.get(0)).getQualifiedName().toString();
        }
        return typeArgument;
    }
}
