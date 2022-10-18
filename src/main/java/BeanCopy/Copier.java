package BeanCopy;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.List;

public class Copier {
    private static MapperFacade mapper;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapper = mapperFactory.getMapperFacade();
    }

    public static void main(String[] args) {
        NeedCopyBean b1 = new NeedCopyBean();
        b1.setNum(10);
        List<String> l1 = new ArrayList<>();
        l1.add("1");
        l1.add("2");
        b1.setStringList(l1);

        NeedCopyBean b2 = mapper.map(b1, NeedCopyBean.class);
        System.out.println();
    }
}
