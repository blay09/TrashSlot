package net.blay09.mods.trashslot.net;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageTrashSlotClick implements IMessage {

	private ItemStack itemStack;
	private boolean isRightClick;

	public MessageTrashSlotClick() {
	}

	public MessageTrashSlotClick(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		itemStack = ByteBufUtils.readItemStack(buf);
		isRightClick = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeItemStack(buf, itemStack);
		buf.writeBoolean(isRightClick);
	}

	public ItemStack getItemStack() {
		return itemStack;
	}
}
