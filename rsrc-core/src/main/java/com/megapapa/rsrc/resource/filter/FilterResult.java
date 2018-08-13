package com.megapapa.rsrc.resource.filter;

import com.google.common.base.Joiner;

import java.util.LinkedList;
import java.util.List;

/**
 * Class, which contains all data about filtering. Produced on each doFilter(...).
 */
public class FilterResult {

    private static final String DEFAULT_COMPLETE_MESSAGE = "Filtering complete successful.";

    private FilterResultType filterResultType;
    private List<String> usedFilters;
    private String additionalInformation;

    public FilterResult() {
        usedFilters = new LinkedList<>();
    }

    public void fail(Throwable throwable) {
        filterResultType = FilterResultType.Fail;
        additionalInformation = throwable.getLocalizedMessage();
    }

    public void success() {
        success(DEFAULT_COMPLETE_MESSAGE);
    }

    public void success(String additionalInformation) {
        filterResultType = FilterResultType.Ok;
        this.additionalInformation = additionalInformation;
    }

    public void stamp(Filter filter) {
        usedFilters.add(filter.getFilterName() + ":" + filter.getFilterLevel());
    }

    public boolean isSuccess() {
        return filterResultType == FilterResultType.Ok;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public String report() {
        String format = "%s : Filtering complete with result: %s.\n Additional information: %s";
        return String.format(format, Joiner.on(", ").join(usedFilters), filterResultType, additionalInformation);
    }
}
