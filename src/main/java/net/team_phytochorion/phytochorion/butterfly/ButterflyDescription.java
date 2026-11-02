package net.team_phytochorion.phytochorion.butterfly;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.GsonHelper;

import java.util.Arrays;
import java.util.List;

public class ButterflyDescription {
    //private final ParticleDescription sideDescription;
    //private final ParticleDescription topDescription;
    //private final List<BlockState> blockStates;
    private final List<String> words;

    private ButterflyDescription(List<String> pWords)
    {
        words = pWords;
    }

    public void write(){
        System.out.println(words);
    }

    public static ButterflyDescription fromJson(JsonObject pJson) {
        JsonArray jsonarray = GsonHelper.getAsJsonArray(pJson, "words", (JsonArray)null);
        if (jsonarray == null) {
            return new ButterflyDescription(List.of());
        } else {
            List<String> list = Streams.stream(jsonarray).map((p_107284_) -> {
                return GsonHelper.convertToString(p_107284_, "texture");
            }).collect(ImmutableList.toImmutableList());
            return new ButterflyDescription(list);
        }
    }
}
