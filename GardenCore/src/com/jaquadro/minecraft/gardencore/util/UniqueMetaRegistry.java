package com.jaquadro.minecraft.gardencore.util;

import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UniqueMetaRegistry<E>
{
    private Map<UniqueMetaIdentifier, E> registry;

    public UniqueMetaRegistry () {
        registry = new HashMap<UniqueMetaIdentifier, E>();
    }

    public void register (UniqueMetaIdentifier id, E entry) {
        registry.put(id, entry);
    }

    public E getEntry (UniqueMetaIdentifier id) {
        if (registry.containsKey(id))
            return registry.get(id);

        if (id.meta != OreDictionary.WILDCARD_VALUE) {
            id = new UniqueMetaIdentifier(id.modId, id.name, OreDictionary.WILDCARD_VALUE);
            if (registry.containsKey(id))
                return registry.get(id);
        }

        return null;
    }

    public Set<Map.Entry<UniqueMetaIdentifier, E>> entrySet () {
        return registry.entrySet();
    }
}
