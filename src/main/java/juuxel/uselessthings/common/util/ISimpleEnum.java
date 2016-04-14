package juuxel.uselessthings.common.util;

import net.minecraft.util.IStringSerializable;

public interface ISimpleEnum extends IStringSerializable
{
    String name();

    @Override
    default String getName()
    {
        return name().toLowerCase(java.util.Locale.ROOT);
    }
}
