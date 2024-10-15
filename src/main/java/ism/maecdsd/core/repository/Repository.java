package ism.maecdsd.core.repository;

import java.util.List;

public interface Repository<Entity> {
    // Genericite==> Variance des Types(Objet) une application
    // int ,float ,double ,char
    // Entity ==> Type Generique
    // public <Entity> List<Entity> read();
    // public <Entity> void create(Entity entity);

    public List<Entity> read();
    public void create(Entity entity);

}
