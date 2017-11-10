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
package org.jboss.hal.dmr.stream;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.jboss.hal.dmr.ModelType;

/**
 * DMR writer. Instances of this interface are not thread safe.
 *
 * @author <a href="mailto:ropalka@redhat.com">Richard Opalka</a>
 * @see ModelStreamFactory
 */
public interface ModelWriter {

    /**
     * Writes DMR <code>object start</code> token.
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeObjectStart() throws ModelException;

    /**
     * Writes DMR <code>object end</code> token.
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeObjectEnd() throws ModelException;

    /**
     * Writes DMR <code>property start</code> token.
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writePropertyStart() throws ModelException;

    /**
     * Writes DMR <code>property end</code> token.
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writePropertyEnd() throws ModelException;

    /**
     * Writes DMR <code>list start</code> token.
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeListStart() throws ModelException;

    /**
     * Writes DMR <code>list end</code> token.
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeListEnd() throws ModelException;

    /**
     * Writes DMR <code>undefined</code> token.
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeUndefined() throws ModelException;

    /**
     * Writes DMR <code>string</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeString(String data) throws ModelException;

    /**
     * Writes DMR <code>expression</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeExpression(String data) throws ModelException;

    /**
     * Writes DMR <code>bytes</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeBytes(byte[] data) throws ModelException;

    /**
     * Writes DMR <code>true</code> or <code>false</code> token.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeBoolean(boolean data) throws ModelException;

    /**
     * Writes DMR <code>number</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeInt(int data) throws ModelException;

    /**
     * Writes DMR <code>number</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeLong(long data) throws ModelException;

    /**
     * Writes DMR <code>number</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeBigInteger(BigInteger data) throws ModelException;

    /**
     * Writes DMR <code>number</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeBigDecimal(BigDecimal data) throws ModelException;

    /**
     * Writes DMR <code>number</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeDouble(double data) throws ModelException;

    /**
     * Writes DMR <code>type</code>.
     *
     * @param data to encode
     *
     * @return this writer instance
     *
     * @throws ModelException if invalid DMR write attempt is detected
     */
    ModelWriter writeType(ModelType data) throws ModelException;
}