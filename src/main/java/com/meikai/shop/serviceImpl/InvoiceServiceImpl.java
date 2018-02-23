/**
 * 
 */
package com.meikai.shop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meikai.shop.dao.TShopInvoiceDao;
import com.meikai.shop.entity.TShopInvoice;
import com.meikai.shop.service.InvoiceService;

/**
 * 发票
 * @author meikai
 * @version 2017年9月23日 下午9:58:37
 */

@Service("invoiceServiceImpl")
public class InvoiceServiceImpl extends BaseServiceImpl<TShopInvoice, Long> implements InvoiceService {

	
	@Autowired
	private TShopInvoiceDao invoiceDao;
	
	@Autowired
	public void setBaseDao() {
		super.setBaseDao(invoiceDao);
	}
	
	
}
