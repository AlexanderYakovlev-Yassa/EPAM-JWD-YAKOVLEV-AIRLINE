package by.epam.jwd.yakovlev.airline.tag;

import by.epam.jwd.yakovlev.airline.controller.ControllerServlet;
import by.epam.jwd.yakovlev.airline.tag.util.Converter;
import by.epam.jwd.yakovlev.airline.tag.util.impl.EmployeeConverter;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Properties;

public class EmloyeeTable extends SimpleTagSupport {

    private static final Logger LOGGER = Logger.getLogger(ControllerServlet.class);
    private static final String WHITE_SPACE_REGEX = "[\\s]+";

    private static final String QUOTE = "\"";
    private static final String EMPTY = "";
    private static final String CLASS_EQUAL = "class=";
    private static final String CONTENT_NOT_FOUND_MESSAGE = "<p align=\"center\">Content not recognised</p>";
    private static final String CONTENT_NOT_RECOGNISED_MESSAGE = "<p align=\"center\">Content not recognised</p>";
    private static final String NO_COLUMNS_PICKED_MESSAGE = "<p align=\"center\">No columns picked</p>";
    private static final String TABLE_TAG = "<table ";
    private static final String CLOSE_TAG = ">";
    private static final String TR_TAG_ONCLICK_FILLFORM = "<tr onclick=\"fillForm(";
    private static final String COMA_WS_APOSTROPHE = ", \'";
    private static final String APOSTROPHE_COMA_WS_APOSTROPHE = "\', \'";
    private static final String APOSTROPHE_COMA_R_BRACKET_QUOTE_CLOSE_TAG = "\')\" >";
    private static final String TD_TAG = "<td>";
    private static final String CLOSE_TD_TAG = "</td>";
    private static final String CLOSE_TR_TAG = "</tr>";
    private static final String CLOSE_TABLE_TAG = "</table>";

    private StringWriter sw = new StringWriter();

    private String columns;
    private String styleClass;

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    @Override
    public void doTag() throws JspException, IOException {

        StringBuffer sb = new StringBuffer();

        String styleClassAttribute = styleClass != null ? CLASS_EQUAL + QUOTE + styleClass + QUOTE : EMPTY;

        Converter converter = new EmployeeConverter();
        Object object = getJspContext().getAttribute(StringConstant.ALL_EMPLOYEE_LIST_KEY.getValue(),
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

        if (columns == null) {
            sb.append(NO_COLUMNS_PICKED_MESSAGE);
            getJspContext().getOut().println(sb.toString());
        }

        sb.append(TABLE_TAG + styleClassAttribute + CLOSE_TAG);
        String[] columnsNameArray = columns.split(WHITE_SPACE_REGEX);

        Properties temporaryProperties;
        String id;
        String nickname;
        String firsName;
        String lastName;
        String systemRoleID;
        String systemRoleName;
        String crewRoleID;
        String crewRoleName;

        for (Object o : objectsList) {
            temporaryProperties = converter.convertToProperties(o);
            id = temporaryProperties.getProperty(StringConstant.EMPLOYEE_ID_KEY.getValue());
            nickname = temporaryProperties.getProperty(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue());
            firsName = temporaryProperties.getProperty(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue());
            lastName = temporaryProperties.getProperty(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue());
            systemRoleID = temporaryProperties.getProperty(StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
            systemRoleName = temporaryProperties.getProperty(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue());
            crewRoleID = temporaryProperties.getProperty(StringConstant.CREW_ROLE_ID_KEY.getValue());
            crewRoleName = temporaryProperties.getProperty(StringConstant.CREW_ROLE_NAME_KEY.getValue());

            sb.append(TR_TAG_ONCLICK_FILLFORM +
                    id + COMA_WS_APOSTROPHE +
                    nickname + APOSTROPHE_COMA_WS_APOSTROPHE +
                    firsName + APOSTROPHE_COMA_WS_APOSTROPHE +
                    lastName + APOSTROPHE_COMA_WS_APOSTROPHE +
                    systemRoleID + APOSTROPHE_COMA_WS_APOSTROPHE +
                    systemRoleName + APOSTROPHE_COMA_WS_APOSTROPHE +
                    crewRoleID + APOSTROPHE_COMA_WS_APOSTROPHE +
                    crewRoleName + APOSTROPHE_COMA_R_BRACKET_QUOTE_CLOSE_TAG);
            for (String col : columnsNameArray) {
                sb.append(TD_TAG + temporaryProperties.getProperty(col) + CLOSE_TD_TAG);
            }
            sb.append(CLOSE_TR_TAG);
        }

        sb.append(CLOSE_TABLE_TAG);

        getJspContext().getOut().println(sb.toString());
    }
}
