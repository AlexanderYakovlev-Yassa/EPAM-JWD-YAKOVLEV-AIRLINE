package by.epam.jwd.yakovlev.airline.tag;

import by.epam.jwd.yakovlev.airline.tag.util.Converter;
import by.epam.jwd.yakovlev.airline.tag.util.impl.CrewRoleConverter;
import by.epam.jwd.yakovlev.airline.tag.util.impl.SystemRoleConverter;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Properties;

public class CrewRoleDropdown extends SimpleTagSupport {

    private StringWriter sw = new StringWriter();

    private String styleClass;

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
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

        Converter converter = new CrewRoleConverter();

        Object object = getJspContext().getAttribute(StringConstant.ALL_CREW_ROLE_LIST_KEY.getValue(),
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
                "id=\"current-employee-crew-role-name\" current-employee-crew-role-id=\"\">" +
                "undefined" + "</button>");
        sb.append("<div class=\"dropdown-menu\">");

        Properties temporaryProperties;
        String id;
        String crewRoleName;

        for (Object o : objectsList) {
            temporaryProperties = converter.convertToProperties(o);
            id = temporaryProperties.getProperty(StringConstant.CREW_ROLE_ID_KEY.getValue());
            crewRoleName = temporaryProperties.getProperty(StringConstant.CREW_ROLE_NAME_KEY.getValue());

            sb.append("<a class=\"dropdown-item\" href=\"#\" onclick=\"dropDownPick( 'current-employee-crew-role-name', '" +
                    crewRoleName + "', 'current-employee-crew-role-id', '" + id + "')\">" + crewRoleName + "</a>");
        }

        sb.append("<div class=\"dropdown-divider\"></div>\n" +
                "  </div>\n" +
                "</div>");

        getJspContext().getOut().println(sb.toString());
    }
}
