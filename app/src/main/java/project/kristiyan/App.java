package project.kristiyan;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import project.kristiyan.database.Database;

public class App {

    public static JDA jda;
    public static Database database;

    public static void main(String[] args) throws InterruptedException {
        JDABuilder builder = JDABuilder.createDefault(
                        System.getenv("DAILY_QUESTIONS_DISCORD_BOT_TOKEN"),
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_VOICE_STATES)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setChunkingFilter(ChunkingFilter.ALL);

        jda = builder.build();

        jda.addEventListener();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        }));

        jda.awaitReady();
    }
}
