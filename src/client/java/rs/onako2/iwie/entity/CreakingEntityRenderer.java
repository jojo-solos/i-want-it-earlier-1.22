package rs.onako2.iwie.entity;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EndermanEyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer;
import net.minecraft.util.Identifier;
import rs.onako2.iwie.ClientInit;

public class CreakingEntityRenderer extends MobEntityRenderer<CreakingEntity, CreakingModel> {

    private static final Identifier TEXTURE = Identifier.of("iwie", "textures/entity/creaking/creaking.png");



    public CreakingEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CreakingModel(context.getPart(ClientInit.MODEL_CREAKING_LAYER)), 0.6f);
        this.addFeature(new CreakingEyesFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(CreakingEntity entity) {
        return TEXTURE;
    }
}
