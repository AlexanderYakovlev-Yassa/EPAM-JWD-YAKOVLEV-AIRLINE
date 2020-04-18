package by.epam.jwd.yakovlev.airline.tag;

import by.epam.jwd.yakovlev.airline.tag.util.Converter;
import by.epam.jwd.yakovlev.airline.tag.util.impl.SystemRoleConverter;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class SystemRoleDropdown extends SimpleTagSupport {

    //private StringWriter sw = new StringWriter();

    private String styleClass;
    private String id;
    private String name;

    

    public SystemRoleDropdown(String styleClass, String id, String name) {
		this.styleClass = styleClass;
		this.id = id;
		this.name = name;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private static final String QUOTE = "\"";
    private static final String EMPTY = "";
    private static final String CLASS_EQUAL = "class=";
    private static final String CONTENT_NOT_FOUND_MESSAGE = "<p align=\"center\">Content not found</p>";
    private static final String CONTENT_NOT_RECOGNISED_MESSAGE = "<p align=\"center\">Content not recognised</p>";

    @Override
    public void doTag() throws JspException, IOException {

        StringBuffer sb = new StringBuffer();

        String styleClassAttribute = styleClass != null ? CLASS_EQUAL + QUOTE + styleClass + QUOTE : EMPTY;

        Converter converter = new SystemRoleConverter();

        Object object = getJspContext().getAttribute(StringConstant.ALL_SYSTEM_ROLE_LIST_KEY.getValue(),
                PageContext.SESSION_SCOPE);

        if (object == null) {
            sb.append(CONTENT_NOT_FOUND_MESSAGE);
            getJspContext().getOut().println(sb.toString());
            return;
        }

        if (object.getClass() != ArrayList.class) {
            sb.append(CONTENT_NOT_RECOGNISED_MESSAGE);
            getJspContext().getOut().println(sb.toString());
            return;
        }

        ArrayList<Object> objectsList = (ArrayList<Object>)object;

        sb.append("<div class=\"btn-group\">");
        sb.append("<button type=\"button\" " + styleClassAttribute +
                " data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" " +
                "id=\"current-employee-system-role-name\" current-employee-system-role-id=\"\">" +
                "undefined" + "</button>");
        sb.append("<div class=\"dropdown-menu\">");

        Properties temporaryProperties;
        String roleId = null;
        String systemRoleName;

        for (Object o : objectsList) {
            temporaryProperties = converter.convertToProperties(o);
            roleId = temporaryProperties.getProperty(StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
            systemRoleName = temporaryProperties.getProperty(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue());

            sb.append("<a class=\"dropdown-item\" href=\"#\" onclick=\"dropDownPick( 'current-employee-system-role-name', '" +
                    systemRoleName + "', 'current-employee-system-role-id', '" + roleId + "')\">" + systemRoleName + "</a>");
        }

        sb.append("<div class=\"dropdown-divider\"></div>\n" +
                "  </div>\n" +
                "</div>");
		/*
		 * sb.append("<input type=\"hidden\" id=\"" + id + "\" name=\"" + name +
		 * "\" />");
		 */

        getJspContext().getOut().println(sb.toString());
    }
}
