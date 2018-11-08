package ${packageName};

import com.platform.configure.base.enums.DeletedType;
import com.platform.configure.condition.Conditions;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class ${className} implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    <#list attrList as attr>
    //${attr.name} 
    private ${attr.type} ${attr.name};
    
    </#list>

    <#list attrList as attr>
    public void set${attr.name?cap_first}(${attr.type} ${attr.name}){
        this.${attr.name} = ${attr.name};
    }
    public ${attr.type} get${attr.name?cap_first}(){
        return this.${attr.name};
    }
    </#list>
}