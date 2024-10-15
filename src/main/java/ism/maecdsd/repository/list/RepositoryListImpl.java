package ism.maecdsd.repository.list;

import java.util.List;

import ism.maecdsd.core.repository.Repository;

import java.util.ArrayList;

public class RepositoryListImpl<Entity> implements Repository<Entity> {
    protected List<Entity> datas = new ArrayList<>();

    // CRUD
    @Override
    public List<Entity> read() {
        return datas;
    }

    @Override
    public void create(Entity entity) {
        datas.add(entity);
    }

}
