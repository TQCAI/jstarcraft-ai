package com.jstarcraft.ai.data.processor;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.ai.data.DataInstance;
import com.jstarcraft.ai.data.DataModule;
import com.jstarcraft.ai.data.module.SparseModule;
import com.jstarcraft.core.utility.KeyValue;

import it.unimi.dsi.fastutil.ints.Int2FloatAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2FloatSortedMap;
import it.unimi.dsi.fastutil.ints.Int2IntAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2IntSortedMap;

public class DataSorterTestCase {

    private String moduleName = "module";

    private int order = 10;

    private int instanceCapacity = 10;

    private DataModule getDataModule() {
        List<KeyValue<KeyValue<String, Boolean>, Integer>> moduleDefinition = new LinkedList<>();
        for (int index = 0; index < order; index++) {
            moduleDefinition.add(new KeyValue<>(new KeyValue<>("quality", true), 1));
            moduleDefinition.add(new KeyValue<>(new KeyValue<>("ontinuous", false), 1));
        }
        DataModule module = new SparseModule(moduleName, moduleDefinition, instanceCapacity);
        Int2IntSortedMap qualityFeatures = new Int2IntAVLTreeMap();
        Int2FloatSortedMap quantityFeatures = new Int2FloatAVLTreeMap();
        for (int index = 0; index < instanceCapacity; index++) {
            qualityFeatures.clear();
            qualityFeatures.put(0, index);
            module.associateInstance(qualityFeatures, quantityFeatures);
        }
        return module;
    }

    @Test
    public void testSort() {
        DataModule module = getDataModule();
        DataSorter sorter = new DataSorter() {

            @Override
            public int sort(DataInstance left, DataInstance right) {
                return right.getQualityFeature(0) - left.getQualityFeature(0);
            }

        };
        module = sorter.sort(module);
        for (int index = 0; index < instanceCapacity; index++) {
            Assert.assertEquals(instanceCapacity - 1 - index, module.getInstance(index).getQualityFeature(0));
        }
    }

}
