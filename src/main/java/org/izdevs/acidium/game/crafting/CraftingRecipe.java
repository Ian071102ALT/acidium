package org.izdevs.acidium.game.crafting;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.izdevs.acidium.game.equipment.Equipment;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public class CraftingRecipe {
    Equipment destination;
    String name;
    boolean ordered = false;
    boolean craftable = true;
    Set<CraftingSlot> slots = new HashSet<>();

    public CraftingRecipe(@NotNull CraftingSlot... craftingSlots) {
        Collections.addAll(slots, craftingSlots);
    }

    public CraftingRecipe(@NotNull String name) {
        this.name = name;
    }

    /**
     * constructors for un-craft-able items
     */
    public CraftingRecipe() {
        this.craftable = false;
    }

    /**
     * validates that if the crafting recipe provided can produce the destination item
     * @param input the provided recipe
     * @return if the crafting recipe provided can produce the destination item
     */
    public boolean validate(CraftingRecipe input) {
        if (!craftable) return false;
        else {
            return slots.equals(input.slots);
        }
    }

    public CraftingRecipe(Set<CraftingSlot> grid){
        this.slots = grid;
    }
}
