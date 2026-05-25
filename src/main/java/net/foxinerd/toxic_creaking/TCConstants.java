package net.foxinerd.toxic_creaking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class TCConstants {
    public static final String MOD_ID = "toxic_creaking";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static boolean UNSTABLE_LOGGING = FabricLoader.getInstance().isDevelopmentEnvironment();

    public static @NotNull Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static void log(String string) {
        log(string, UNSTABLE_LOGGING);
    }

    public static void log(String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info(string);
        }
    }

    public static void logWithModId(String string) {
        logWithModId(string, UNSTABLE_LOGGING);
    }

    public static void logWithModId(String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info("{} " + MOD_ID, string);
        }
    }

    public static void warn(String string) {
        warn(string, UNSTABLE_LOGGING);
    }

    public static void warn(String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.warn(string);
        }
    }
}
