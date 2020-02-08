package com.larry.mvcsample;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class RolesRequestCondition implements RequestCondition<RolesRequestCondition> {

    private final Set<String> roles;

    public RolesRequestCondition(String... roles) {
        this(Arrays.asList(roles));
    }

    private RolesRequestCondition(Collection<String> roles) {
        this.roles = Collections.unmodifiableSet(new HashSet<String>(roles));
    }

    @Override
    public RolesRequestCondition combine(RolesRequestCondition other) {
        Set<String> allRoles = new LinkedHashSet<String>(this.roles);
        allRoles.addAll(other.roles);
        return new RolesRequestCondition(allRoles);
    }

    @Override
    public RolesRequestCondition getMatchingCondition(HttpServletRequest request) {
        String role = request.getHeader("role");
        if (roles.contains(role)) {
            return this;
        }
        throw new AuthorizationException(role);
    }

    @Override
    public int compareTo(RolesRequestCondition other, HttpServletRequest request) {
        return other.roles.size() - this.roles.size();
    }

}
