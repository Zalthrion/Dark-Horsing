package mod.darkhorsing.main;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.darkhorsing.main.DarkHorsingCommonProxy;
import mod.darkhorsing.handlers.DarkHorsingServerPacketHandler;
import mod.darkhorsing.handlers.DarkHorsingClientPacketHandler;
import mod.darkhorsing.items.Withered_Bone;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed

clientPacketHandlerSpec = @SidedPacketHandler(channels = {"DarkHorsing"}, 
packetHandler = DarkHorsingClientPacketHandler.class), //For clientside packet handling

serverPacketHandlerSpec = @SidedPacketHandler(channels = {"DarkHorsing"}, 
packetHandler = DarkHorsingServerPacketHandler.class)) //For serverside packet handling


//MOD BASICS

@Mod(modid="DarkHorsing",name="Dark Horsing",version="Alpha")



public class DarkHorsing {


@Instance("DarkHorsing") //The instance, this is very important later on

public static DarkHorsing instance ;


@SidedProxy(clientSide = "mod.darkhorsing.client.DarkHorsingClientProxy", serverSide = "mod.darkhorsing.main.DarkHorsingCommonProxy") //Tells Forge the location of your proxies

public static DarkHorsingCommonProxy proxy;


//Creative Tabs

//Main Creative Tab (Dark Horsing)

public static CreativeTabs Dark_Horsing = new CreativeTabs("Dark Horsing") {

    public ItemStack getIconItemStack() {

        return new ItemStack(Item.blazePowder, 1, 0);
    }
};


//ITEMS

public static Item Withered_Bone;


//ACHIEVEMENTS

public static Achievement Infernal_Whisperer;


//OTHERS

//(Empty)

   @EventHandler

     public void PreInit(FMLPreInitializationEvent e){


//ITEMS

//Purified Emerald

Withered_Bone= new Withered_Bone(4600)
.setUnlocalizedName("Withered Bone")
.setCreativeTab(this.Dark_Horsing); //5134 (5434) is the ID

GameRegistry.registerItem(Withered_Bone, "Withered Bone");


}


//Achievements

//{

//Upgrade

{
	
Infernal_Whisperer = new Achievement
(3432, "Infernal_Whisperer", 4, -4, 
Item.blazePowder, 
AchievementList.buildWorkBench)
.setSpecial()
.registerAchievement();

this.addAchievementName("Infernal_Whisperer", "Infernal_Whisperer");

this.addAchievementDesc("Infernal Whisperer", "Tame an Infernal Horse");

}


//Achievements Desc and Names

private void addAchievementName(String ach, String name)
    {
    LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
}


private void addAchievementDesc(String ach, String desc)
    {
    LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
}


   @EventHandler

     public void InitDarkHorsing(FMLInitializationEvent event){ //Your main initialization method


//ItemStack

//ItemStack Withered_BoneStack = new ItemStack(Withered_Bone);


//Recipes

//Crafting Recipe for Reinforced Emerald Block, Using Hardened Emerald Blocks.

//GameRegistry.addRecipe(Withered_BoneStack, "yxy", "xlx", "yxy",  'y', Withered_BoneStack, 'x', Withered_BoneStack, 'l', Withered_BoneStack);

//Crafting Recipe for Reinforced Emerald

//GameRegistry.addShapelessRecipe(new ItemStack(DarkHorsing.Withered_Bone, 1), new ItemStack(DarkHorsing.Withered_Bone));


//Smelting

//GameRegistry.addSmelting(Withered_Bone.itemID, 
//new ItemStack(DarkHorsing.Withered_Bone), 0.0F);


//CREATIVE TAB (METHOD)

//Dark Horsing

LanguageRegistry.instance().addStringLocalization("itemGroup.Dark Horsing", "en_US", "Dark Horsing");


//BLOCKS (METHOD)

proxy.registerBlocks(); //Calls the registerBlocks method


//ITEMS (METHOD)

proxy.registerItems(); //Calls the RegisterItems method


//MULTIPLAYER ABILITY

//	NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data


}

private void addAchievementLocalizations() {

}

}