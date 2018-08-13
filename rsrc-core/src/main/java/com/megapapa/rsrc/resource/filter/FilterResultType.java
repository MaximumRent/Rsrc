package com.megapapa.rsrc.resource.filter;

public enum FilterResultType {

    Ok, Fail;

    @Override
    public String toString() {
        if (this.equals(Ok)) {
            return "Ok";
        }
        return "Fail";
    }
}
