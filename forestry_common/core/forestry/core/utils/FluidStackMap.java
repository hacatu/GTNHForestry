/*******************************************************************************
 * Copyright 2011-2014 by SirSengir
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/.
 ******************************************************************************/
package forestry.core.utils;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FluidStackMap<T> extends StackMap<FluidStack, T> {
	private static final long serialVersionUID = -3314134471346370713L;

	@Override
	protected boolean areEqual(FluidStack a, Object b) {

		if(b instanceof FluidStack)
			return a.isFluidEqual((FluidStack) b);
		if(b instanceof Fluid) {
			return ((Fluid)b).getID() == a.getFluid().getID();
		} if(b instanceof String)
			return ((String)b).equals(a.getFluid().getName());
		return false;
	}

	@Override
	protected boolean isValidKey(Object key) {
		return key instanceof FluidStack || key instanceof Fluid || key instanceof String;
	}

	@Override
	protected FluidStack getStack(Object key) {
		if (key instanceof FluidStack)
			return (FluidStack) key;
		if (key instanceof Fluid)
			return LiquidHelper.getLiquid(((Fluid) key).getName(), 1);
		if (key instanceof String)
			return LiquidHelper.getLiquid((String) key, 1);
		return null;
	}

}