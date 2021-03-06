/*
 * Copyright 2011 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.ide.common.client.modeldriven.brl.templates;

public class InterpolationVariable {

    private String varName;
    private String dataType;
    private String factType;
    private String factField;

    public InterpolationVariable(String varName,
                                 String dataType) {
        this.varName = varName;
        this.dataType = dataType;
    }

    public InterpolationVariable(String varName,
                                 String dataType,
                                 String factType,
                                 String factField) {
        this.varName = varName;
        this.dataType = dataType;
        this.factType = factType;
        this.factField = getLeafFieldName( factField );
    }

    private boolean equalOrNull(Object lhs,
                                    Object rhs) {
        if ( lhs == null && rhs == null ) {
            return true;
        }
        if ( lhs != null && rhs == null ) {
            return false;
        }
        if ( lhs == null && rhs != null ) {
            return false;
        }
        return lhs.equals( rhs );
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj == null ) {
            return false;
        }
        if ( !(obj instanceof InterpolationVariable) ) {
            return false;
        }
        InterpolationVariable that = (InterpolationVariable) obj;
        return equalOrNull( this.varName,
                                that.varName ) && equalOrNull( this.dataType,
                                                               that.dataType ) && equalOrNull( this.factType,
                                                                                               that.factType ) && equalOrNull( this.factField,
                                                                                                                               that.factField );
    }

    public String getDataType() {
        return dataType;
    }

    public String getFactField() {
        return factField;
    }

    public String getFactType() {
        return factType;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public int hashCode() {
        int hashCode = (varName == null ? 1 : varName.hashCode());
        hashCode = hashCode + 31 * (dataType == null ? 7 : dataType.hashCode());
        hashCode = hashCode + 31 * (factType == null ? 7 : factType.hashCode());
        hashCode = hashCode + 31 * (factField == null ? 7 : factField.hashCode());
        return hashCode;
    }

    public void setFactField(String factField) {
        this.factField = getLeafFieldName( factField );
    }

    public void setFactType(String factType) {
        this.factType = factType;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    private String getLeafFieldName(String qualifiedFieldName) {
        if ( qualifiedFieldName != null ) {
            if ( qualifiedFieldName.contains( "." ) ) {
                return qualifiedFieldName.substring( qualifiedFieldName.indexOf( "." ) + 1 );
            }
        }
        return qualifiedFieldName;
    }

}
