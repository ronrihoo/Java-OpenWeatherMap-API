package owmapi;

public abstract class AbstractOwmApi {

    protected String appId = null;
    protected HttpConnection httpConnection = null;
    protected OwmGenerator url = null;
    protected OwmParser owmParser = null;
    protected Regex regex;

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public boolean parseForCall(String target, String[] keywords) {
        for (String keyword : keywords) {
            if (target.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public String validateInput(String str) {
        if (regex.testZipCode(str).length() >= 5) {
            return regex.testZipCode(str);
        } else {
            return null;
        }
    }

    public String makeApiCall(String str) {
        str = validateInput(str);
        if (str != null && hasAppId()) {
            url = new OwmGenerator(str, appId);
            return httpConnection.getResponse(url.getByZipCodeUrl());
        } else {
            printCurrentError(str);
        }
        return null;
    }

    public String parseJsonContents(String str) {
        return owmParser.parseWeatherInfo(str).report();
    }

    public boolean validateJsonContent(String json) {
        return json != null && json.charAt(0) == '{' &&
                json.charAt(json.length() - 1) == '}';
    }
    
    public String returnResult(String str) {
        str = makeApiCall(str);
        if (validateJsonContent(str)) {
            return parseJsonContents(str);
        }
        return null;
    }

    public boolean hasAppId() {
        return appId != null;
    }

    public void printMissingAppIdError() {
        System.out.println("OwmApi Error: missing app ID. " +
                "Set app ID with the setAppId(String appId) method.");
    }

    public void printInvalidInputError() {
        System.out.println("OwmApi Error: invalid input.");
    }

    public void printCurrentError(String input) {
        if (input == null) {
            printInvalidInputError();
        } else if (!hasAppId()) {
            printMissingAppIdError();
        }
    }

}
