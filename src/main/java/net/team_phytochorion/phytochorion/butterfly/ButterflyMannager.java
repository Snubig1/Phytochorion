package net.team_phytochorion.phytochorion.butterfly;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.List;
import java.util.Map;

public class ButterflyMannager extends SimpleJsonResourceReloadListener {
    private List<ButterflyDescription> descriptions =  Lists.newArrayList();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();

    public ButterflyMannager() {
        super(GSON, "butterflies");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> pObject, ResourceManager pResourceManager, ProfilerFiller pProfiler) {

        for(Map.Entry<ResourceLocation, JsonElement> entry : pObject.entrySet())
        {
            System.out.println("????????????????????????????????");
            ButterflyDescription.fromJson(entry.getValue().getAsJsonObject()).write();
        }
    }
}
