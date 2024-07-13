package net.siniplise.scsm.utils;

import com.mojang.authlib.GameProfile;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;

import java.io.DataOutput;
import java.io.IOException;

public class CachePlayerHashMap {
    public static ItemStack cachePlayerHash (GameProfile profile) {

        ItemStack stack = new ItemStack(Items.PLAYER_HEAD.getItem(), 1);
        CompoundNBT nbt = stack.getOrCreateTag();
        DataOutput dataOutput = (DataOutput) NBTUtil.writeGameProfile(nbt, profile);
        try {
            nbt.write(dataOutput);
        } catch (IOException e) {

            e.printStackTrace();
        }
        stack.setTag(nbt);
        return stack;
    }
}
