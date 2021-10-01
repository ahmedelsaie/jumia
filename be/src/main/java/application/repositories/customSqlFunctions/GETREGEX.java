package application.repositories.customSqlFunctions;

import org.sqlite.Function;

import java.sql.SQLException;

public class GETREGEX extends Function {

    @Override
    protected void xFunc() throws SQLException {
        String expression = value_text(0);
        result(getCountryCodeRegex(expression));
    }

    private String getCountryCodeRegex(String code) {
        String ret = "\\(" + code + "\\)\\ ";
        return ret;
    }
}
