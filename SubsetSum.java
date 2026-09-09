/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad3;

public class SubsetSum {
    public static boolean subsetSum(int[] set, int n, int target) {
        if (target == 0) return true;
        if (n == 0) return false;
        if (set[n - 1] > target) return subsetSum(set, n - 1, target);
        return subsetSum(set, n - 1, target)
            || subsetSum(set, n - 1, target - set[n - 1]);
    }
}