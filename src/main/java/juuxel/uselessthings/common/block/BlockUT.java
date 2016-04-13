package juuxel.uselessthings.common.block;

import juuxel.uselessthings.common.util.IBlock;
import juuxel.uselessthings.lib.LibMisc;
import juuxel.uselessthings.lib.TabUT;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockUT extends Block implements IBlock
{
    public BlockUT()
    {
        this(Material.ROCK);
    }

    public BlockUT(Material material)
    {
        super(material);
        setCreativeTab(TabUT.TAB_UT);
    }

    public void setName(String name)
    {
        setUnlocalizedName(LibMisc.ID_LOWER + "." + name);
        setRegistryName(name);
    }
}
