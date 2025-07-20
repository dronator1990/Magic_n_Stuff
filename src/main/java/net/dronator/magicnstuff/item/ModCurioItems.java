package net.dronator.magicnstuff.item;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.dronator.magicnstuff.Magicnstuff;
import net.dronator.magicnstuff.compat.Curios;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCurioItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Magicnstuff.MODID);

    public static final Supplier<CurioBaseItem> GREATER_MANA_RING = ITEMS.register("greater_mana_ring",
            () -> new CurioBaseItem(ItemPropertiesHelper.equipment(1))
                    .withAttributes(Curios.RING,
                            new AttributeContainer(AttributeRegistry.MAX_MANA, 175, AttributeModifier.Operation.ADD_VALUE),
                            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    ));

    public static final Supplier<CurioBaseItem> SUPERIOR_MANA_RING = ITEMS.register("superior_mana_ring",
            () -> new CurioBaseItem(ItemPropertiesHelper.equipment(1))
                    .withAttributes(Curios.RING,
                            new AttributeContainer(AttributeRegistry.MAX_MANA, 250, AttributeModifier.Operation.ADD_VALUE),
                            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                            new AttributeContainer(AttributeRegistry.MANA_REGEN, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
