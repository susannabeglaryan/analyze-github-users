package com.analyzegithubusers.service.filter;

import org.springframework.data.jpa.domain.Specification;

public class BaseSpecBuilder<T> {

    private Specification<T> spec;

    public BaseSpecBuilder() {
        spec = Specification.where(null);
    }

    protected void apply(Object field, Specification<T> anotherSpec) {
        if(field != null) {
            spec = spec.and(anotherSpec);
        }
    }

    protected String likeUpper(String str) {
        return "%" + str.toUpperCase() + "%";
    }

    public Specification<T> build(){
        return spec;
    }

}
