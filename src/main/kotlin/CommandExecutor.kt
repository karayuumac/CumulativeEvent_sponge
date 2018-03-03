import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.text.Text

/**
 * Created by karayuu on 2018/03/01
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */
class CommandExecutor : CommandExecutor {
    override fun execute(src: CommandSource?, args: CommandContext?): CommandResult {
        src?.sendMessage(Text.of("このコマンドはテストです。"))
        return CommandResult.success()
    }
}
