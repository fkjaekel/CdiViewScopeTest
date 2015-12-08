/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testcase.cdiviewscopetest;

import javax.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * @author fjaekel
 */
public class ViewScopedBeanNGTest extends EjbContainerTest
{
   @Inject
   private ViewScopedBean bean;
   
   @Test
   public void f()
   {
      bean.increaseValue();
      Assert.assertEquals(bean.getValue(), 1);
   }
}
