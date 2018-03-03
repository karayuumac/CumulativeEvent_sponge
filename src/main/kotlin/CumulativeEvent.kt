import command.AbstractCommand
import command.TestCommand
import org.slf4j.Logger
import org.spongepowered.api.Sponge
import org.spongepowered.api.command.args.GenericArguments
import org.spongepowered.api.command.spec.CommandSpec
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GameStartedServerEvent
import org.spongepowered.api.plugin.Plugin
import org.spongepowered.api.text.Text
import javax.inject.Inject

/**
 * Created by karayuu on 2018/02/27
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */
@Plugin(id = "cumulative", name = "Cumulative_Event_Sponge", version = "1.0.0")
class CumulativeEvent {
    @Inject
    private lateinit var logger: Logger

    @Listener
    fun onServerStart(event: GameStartedServerEvent) {
        logger.info("こんばんは！初めてのSpongeプラグインの起動です！")
        Sponge.getCommandManager().register(this, affectSpec, "affect")
        Sponge.getCommandManager().register(this, argSpec, "arg")

        registerCommand(
                TestCommand()
        )
    }

    private val affectSpec = CommandSpec.builder()
            .description(Text.of("AffectEntitiesテストコマンド"))
            .executor(AffectEntitiesExcutor())
            .build()

    private val argSpec = CommandSpec.builder()
            .description(Text.of("引数コマンド"))
            .arguments(
                    GenericArguments.string(Text.of("message"))
            )
            .executor(ArgCommandExcutor())
            .build()

    private val completeSpec = CommandSpec.builder()
            .description(Text.of("TabCompleteのテストコマンド"))
            .arguments(
                    GenericArguments.string(Text.of("message"))
            )

    /**
     * コマンドを登録する関数。
     * @param command [AbstractCommand]を継承したコマンドの設計
     */
    private fun registerCommand(vararg command: AbstractCommand) {
        command.forEach { that ->
            Sponge.getCommandManager().register(this, that.getCommandSpec(), that.getAlias())
        }
    }
}
