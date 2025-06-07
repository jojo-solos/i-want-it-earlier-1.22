package rs.onako2.iwie.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CreakingEyesFeatureRenderer<T extends LivingEntity> extends EyesFeatureRenderer<T, EndermanEntityModel<T>> {

    private static final RenderLayer EYES_TEXTURE = RenderLayer.getEyes(Identifier.of("iwie","textures/entity/creaking/creaking_eyes.png"));

    public CreakingEyesFeatureRenderer(FeatureRendererContext<T, EndermanEntityModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return EYES_TEXTURE;
    }
}
