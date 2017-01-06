package wint.sessionx.filter;

import wint.lang.magic.MagicMap;

/**
 * User: longyi
 * Date: 14-2-26
 * Time: 下午1:17
 */
public interface Filter {

    String getName();

    void init(MagicMap initParameters);

    void doFilter(FilterContext filterContext);

}
