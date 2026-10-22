package net.team_phytochorion.phytochorion.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.particles.SimpleParticleType;


public class ButterflyParticles extends TextureSheetParticle {
    protected LocalPlayer player;
    private final SpriteSet sprites;

    protected ButterflyParticles(ClientLevel pLevel, double pX, double pY, double pZ,
                                 double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.xd = pX;
        this.yd = pY;
        this.zd = pZ;

        this.friction = 1f;
        this.gravity = -0.1F;
        this.quadSize = 0.5f;
        this.lifetime = 100;
        this.sprites = pSprites;

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;

        player = pLevel.minecraft.player;
        this.setSpriteFromAge(sprites);


    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSprite(sprites.get(this.age%10, 10));
            move(0, 0, 0);
        }
    }


    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType>{
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }


        @Override
        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new ButterflyParticles(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.spriteSet);
        }
    }
}
