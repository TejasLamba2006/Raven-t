package minimap.client.module.modules.other;

import com.google.common.eventbus.Subscribe;
import minimap.client.event.impl.PacketEvent;
import minimap.client.module.Module;
import minimap.client.module.modules.player.NoFall;
import minimap.client.module.setting.impl.ComboSetting;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;

public class ClientSpoofer extends Module {

    public static ComboSetting mode;

    public ClientSpoofer() {
        super("ClientSpoofer", ModuleCategory.other);
        this.registerSetting(mode = new ComboSetting("Mode", Mode.Forge));
    }

    @Subscribe
    public void onPacket(PacketEvent e) {
        if (e.isOutgoing()) {
            final Packet<?> packet = e.getPacket();

            if (packet instanceof C17PacketCustomPayload) {
                final C17PacketCustomPayload wrapper = (C17PacketCustomPayload) packet;

                switch ((ClientSpoofer.Mode) mode.getMode()) {
                    case Forge: {
                        mc.thePlayer.sendQueue.addToSendQueue(new C17PacketCustomPayload("FML", new PacketBuffer(Unpooled.buffer()).writeString("FML|HS")));
//                        wrapper.setData(createPacketBuffer("FML", true));
                        break;
                    }

                    case Lunar: {
                        mc.thePlayer.sendQueue.addToSendQueue(new C17PacketCustomPayload("REGISTER", new PacketBuffer(Unpooled.buffer()).writeString("Lunar-Client")));
//                        wrapper.setChannel("REGISTER");
//                        wrapper.setData(createPacketBuffer("Lunar-Client", false));
                        break;
                    }

                    case PvPLounge: {
                        mc.thePlayer.sendQueue.addToSendQueue(new C17PacketCustomPayload("PLC18", new PacketBuffer(Unpooled.buffer()).writeString("PLC18")));
//                        wrapper.setData(createPacketBuffer("PLC18", false));
                        break;
                    }

                    case CheatBreaker: {
                        mc.thePlayer.sendQueue.addToSendQueue(new C17PacketCustomPayload("CB", new PacketBuffer(Unpooled.buffer()).writeString("CB")));
//                        wrapper.setData(createPacketBuffer("CB", true));
                        break;
                    }

                    case Geyser: {
                        // It's meant to be "eyser" don't change it
                        mc.thePlayer.sendQueue.addToSendQueue(new C17PacketCustomPayload("eyser", new PacketBuffer(Unpooled.buffer()).writeString("eyser")));
//                        wrapper.setData(createPacketBuffer("eyser", false));
                        break;
                    }
                }
            }
        }
    }

//    private PacketBuffer createPacketBuffer(final String data, final boolean string) {
//        if (string) {
//            return new PacketBuffer(Unpooled.buffer()).writeString(data);
//        } else {
//            return new PacketBuffer(Unpooled.wrappedBuffer(data.getBytes()));
//        }
//    }
    public enum Mode {
        Forge,
        Lunar,
        PvPLounge,
        CheatBreaker,
        Geyser
    }
}