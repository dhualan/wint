package wint.core.service.supports;

import wint.core.service.bean.BeanFactory;
import wint.lang.magic.MagicObject;
import wint.lang.magic.Property;
import wint.lang.utils.CollectionUtil;

import java.util.Map;
import java.util.Set;

public abstract class AbstractBeanFactory implements BeanFactory {

    public Set<Property> injectProperties(Object target) {
        if (target == null) {
            return null;
        }
        MagicObject magicObject = MagicObject.wrap(target);
        Set<Property> ret = CollectionUtil.newHashSet();
        for (Map.Entry<String, Property> entry : magicObject.getMagicClass().getProperties().entrySet()) {
            String name = entry.getKey();
            Property property = entry.getValue();
            if (property.isWritable()) {
                Object obj = getObject(name);
                if (obj != null) {
                    property.setValue(target, obj);
                    ret.add(property);
                }

            }
        }
        return ret;
    }

}
