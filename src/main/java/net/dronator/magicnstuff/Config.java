package net.dronator.magicnstuff;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Magicnstuff.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ENABLE_CURIOS = BUILDER
            .comment("Enables curio items")
            .define("enableCurios", true);

    private static final ModConfigSpec.BooleanValue ENABLE_UPGRADES = BUILDER
            .comment("Enables upgrade items")
            .define("enableUpgrades", true);

    private static final ModConfigSpec.BooleanValue ENABLE_SPELLBOOKS = BUILDER
            .comment("Enables spellbooks")
            .define("enableSpellbooks", true);

    private static final ModConfigSpec.BooleanValue ENABLE_STAFFS = BUILDER
            .comment("Enables staffs")
            .define("enableStaffs", true);

    private static final ModConfigSpec.BooleanValue ENABLE_ARMORS = BUILDER
            .comment("Enables armors")
            .define("enableArmors", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean enableCurios;
    public static boolean enableUpgrades;
    public static boolean enableSpellbooks;
    public static boolean enableStaffs;
    public static boolean enableArmors;

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        enableUpgrades = ENABLE_UPGRADES.get();
        enableCurios = ENABLE_CURIOS.get();
        enableArmors = ENABLE_ARMORS.get();
        enableStaffs = ENABLE_STAFFS.get();
        enableSpellbooks = ENABLE_SPELLBOOKS.get();
    }
}
