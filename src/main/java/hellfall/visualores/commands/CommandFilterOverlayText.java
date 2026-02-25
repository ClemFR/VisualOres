package hellfall.visualores.commands;

import codechicken.lib.command.ClientCommandBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.SyntaxErrorException;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class CommandFilterOverlayText extends ClientCommandBase {

    public static String overlayFilter = null;

    @Override
    public void execute(Minecraft minecraft, EntityPlayerSP entityPlayerSP, String[] strings) throws CommandException {

        if (strings.length == 0) {
            overlayFilter = null;
            minecraft.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("visualores.command.filter.reset"));
        } else {
            overlayFilter = String.join(" ", strings);
            minecraft.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("visualores.command.filter.success", overlayFilter));
        }

    }

    @Override
    public @Nonnull String getName() {
        return "filter";
    }

    @Override
    public @Nonnull String getUsage(@Nonnull ICommandSender sender) {
        return "visualores.command.filter.usage";
    }

    public static boolean isFiltered(final List<String> description) {
        return overlayFilter == null || String.join(" ", description).toLowerCase().contains(overlayFilter.toLowerCase());
    }
}
