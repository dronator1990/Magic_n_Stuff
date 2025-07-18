package net.dronator.magicnstuff.item;

import io.redspace.ironsspellbooks.item.SpellSlotUpgradeItem;
import net.dronator.magicnstuff.Magicnstuff;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Magicnstuff.MODID);

    public static final DeferredItem<Item> GREATER_SPELL_SLOT_UPGRADE = ITEMS.register("greater_spell_slot_upgrade",() -> new SpellSlotUpgradeItem(15));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
