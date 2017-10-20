package com.euroland.webapi.helpers;

import jmdn.base.util.string.StrUtil;

import java.util.List;

public class SequenceHelper {

    public static final String TAG_OTHER = "o";
    public static final String TAG_DATETIME = "datetime";
    public static final String TAG_ORDER = "order";
    public static final String TAG_ASPECT = "aspect";
    public static final String TAG_ORGANIZATION = "organization";
    public static final String TAG_PERCENT = "percent";
    public static final String TAG_OPERATOR = "operator";
    /*
	 * @description: get aspect argument
	 *
	 * @params: sentence - input sentence, tags: a list labeled tag
	 */
    public static String getAspect(String sentence, List<String> tags) {
        String aspect = "";
        boolean isFound = false;
        List<String> tokens = StrUtil.tokenizeString(sentence);
        if (tokens.size() > 0) {
            if (tokens.size() == 1) {
                aspect = tokens.get(0);
            } else {
                for (int i = 0; i < tags.size(); i++) {
                    String tag = tags.get(i);
                    if (tag != null && !tag.isEmpty() && tag.contains(TAG_ASPECT)) {
                        aspect += " " + tokens.get(i);
                        isFound = true;
                    } else if (tag.equals(TAG_OTHER) && isFound) {
                        break;
                    }
                }
            }
        }
        if (aspect != null && !aspect.isEmpty()) {
            aspect = aspect.replace("?", "");
            aspect = aspect.replace(".", "");
        }
        return aspect;
    }

    public static String getDatetimePhrase(String sentence, List<String> tags) {
        String datetime = "";
        boolean isFound = false;
        List<String> tokens = StrUtil.tokenizeString(sentence);
        if (tokens.size() > 0) {
            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i);
                if (tag != null && !tag.isEmpty() && tag.contains(TAG_DATETIME)) {
                    datetime += " " + tokens.get(i);
                    isFound = true;
                } else if (tag.equals(TAG_OTHER) && isFound) {
                    break;
                }

            }
        }
        if (datetime != null && !datetime.isEmpty()) {
            datetime = datetime.replace("?", "");
            datetime = datetime.replace(".", "");
        }

        // TODO: process many other case to catch up the right date time
        return datetime;
    }

    public static String getOrganizationName(String sentence, List<String> tags) {
        String organizationName = "";
        boolean isFound = false;
        List<String> tokens = StrUtil.tokenizeString(sentence);
        if (tokens.size() > 0) {
            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i);
                if (tag != null && !tag.isEmpty() && tag.contains(TAG_ORGANIZATION)) {
                    organizationName += " " + tokens.get(i);
                    isFound = true;
                } else if (tag.equals(TAG_OTHER) && isFound) {
                    break;
                }
            }
        }
        return organizationName;
    }

    public static String getOrder(String sentence, List<String> tags) {
        String order = "";
        boolean isFound = false;
        List<String> tokens = StrUtil.tokenizeString(sentence);
        if (tokens.size() > 0) {
            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i);
                if (tag != null && !tag.isEmpty() && tag.contains(TAG_ORDER)) {
                    order += " " + tokens.get(i);
                    isFound = true;
                } else if (tag.equals(TAG_OTHER) && isFound) {
                    break;
                }
            }
        }
        return order;
    }

    public static String getIntend(String sentence, List<String> tags) {
        String intend = "";
        boolean isFound = false;
        List<String> tokens = StrUtil.tokenizeString(sentence);
        if (tokens.size() > 0) {
            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i);
                if (tag != null && !tag.isEmpty() && tag.contains(TAG_PERCENT)) {
                    intend += " " + tokens.get(i);
                    isFound = true;
                } else if (tag.equals(TAG_OTHER) && isFound) {
                    break;
                }
            }
        }
        return intend;
    }

    public static String getOperator(String sentence, List<String> tags) {
        String operator = "";
        boolean isFound = false;
        List<String> tokens = StrUtil.tokenizeString(sentence);
        if (tokens.size() > 0) {
            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i);
                if (tag != null && !tag.isEmpty() && tag.contains(TAG_OPERATOR)) {
                    operator += " " + tokens.get(i);
                    isFound = true;
                } else if (tag.equals(TAG_OTHER) && isFound) {
                    break;
                }
            }
        }
        return operator;
    }
}
