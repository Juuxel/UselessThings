package juuxel.uselessthings.common.block;

import juuxel.uselessthings.lib.LibMisc;
import juuxel.uselessthings.lib.TabUT;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockUT extends Block
{
    public BlockUT()
    {
        this(Material.rock);
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

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
