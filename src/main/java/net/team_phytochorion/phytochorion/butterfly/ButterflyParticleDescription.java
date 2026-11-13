package net.team_phytochorion.phytochorion.butterfly;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;

import java.util.List;

public class ButterflyParticleDescription {
    private final List<ResourceLocation> topTextures;
    private final List<ResourceLocation> sideTextures;
    private final List<ResourceLocation> bottomTextures;

    private ButterflyParticleDescription(List<ResourceLocation> pTop, List<ResourceLocation> pSide, List<ResourceLocation> pBottom)
    {
        topTextures = pTop;
        sideTextures = pSide;
        bottomTextures = pBottom;
    }

    public void write(){
        for (ResourceLocation r: topTextures){
            System.out.println(r);
        }

    }

    public static ButterflyParticleDescription fromJson(JsonObject pJson) {
        return new ButterflyParticleDescription(
                readJsonList(GsonHelper.getAsJsonArray(pJson, "top_textures", (JsonArray)null)),
                readJsonList(GsonHelper.getAsJsonArray(pJson, "side_textures", (JsonArray)null)),
                readJsonList(GsonHelper.getAsJsonArray(pJson, "bottom_textures", (JsonArray)null))
        );
    }

    private static List<ResourceLocation> readJsonList(JsonArray jsonarray) {
        if (jsonarray == null) {
            return List.of();
        } else {
            return Streams.stream(jsonarray).map((p_107284_) ->
                GsonHelper.convertToString(p_107284_, "texture")
            ).map(ResourceLocation::parse).collect(ImmutableList.toImmutableList());
        }
    }
}
