package owmapi;

import jsonparser.JsonParserImpl;

public class OwmApi extends AbstractOwmApi {

    public OwmApi() {
        this.httpConnection = new HttpConnection();
        this.owmParser = new OwmParser(new JsonParserImpl());
        this.regex = new Regex(Constants.NUMERIC_PATTERN,
                Constants.ZIPCODE_PATTERN);
    }

    public OwmApi(String appId) {
        this.httpConnection = new HttpConnection();
        this.owmParser = new OwmParser(new JsonParserImpl());
        this.regex = new Regex(Constants.NUMERIC_PATTERN,
                Constants.ZIPCODE_PATTERN);
        setAppId(appId);
    }

    public OwmApi(HttpConnection httpConnection) {
        this.httpConnection = httpConnection;
        this.owmParser = new OwmParser(new JsonParserImpl());
        regex = new Regex(Constants.NUMERIC_PATTERN, Constants.ZIPCODE_PATTERN);
    }

    public OwmApi(HttpConnection httpConnection, OwmParser owmParser,
                  Regex regex) {
        this.httpConnection = httpConnection;
        this.owmParser = owmParser;
        this.regex = regex;
    }

    // returns null if failed
    public String runWithZipcode(String zipcode) {
        if (!hasAppId()) {
            printMissingAppIdError();
            return null;
        }
        if (validateInput(zipcode) != null) {
            return returnResult(zipcode);
        }
        return null;
    }

}
