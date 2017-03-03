package com.vcmy.osgi.localtranslateasslt;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.vcmy.osgi.localtranslateasslt.impls.TranslateServiceLocalImpl;
import com.vcmy.osgi.translateasslt.service.TranslateService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<TranslateService> sr;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		//注册Service服务
		sr = bundleContext.registerService(TranslateService.class, 
				new TranslateServiceLocalImpl(), null);
		System.out.println("本地查询服务已启动！");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		ServiceReference serviceReference = context.getServiceReference(TranslateService.class.getName());
		bundleContext.ungetService(serviceReference);
		System.out.println("本地服务已停止！");
		Activator.context = null;
	}

}
