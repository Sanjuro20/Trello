package com.trello.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.trello.model.Card;
import com.trello.model.Table;
import com.trello.model.Table.TableVisibility;
import com.trello.model.TableList;
import com.trello.service.TableServiceImpl;


@Controller
public class TableController extends AbstractController{
	@Autowired
	private TableServiceImpl tableService;
	
	private static final Logger logger = Logger.getLogger(TableController.class);
	
	@RequestMapping(value="/viewTables")
	public ModelAndView viewTables(Model model) {
		Map<String, Object> map = new HashMap();
		map.put("tables", (List<Table>)tableService.getTables());
		map.put("history", (List<String>) tableService.getHistory().getActivities());
		return new ModelAndView("tableList", map);
	}
	
	@RequestMapping(value="/getHistory")
	public ModelAndView getHistory(Model model) {
		Map<String, Object> map = new HashMap();
		map.put("history", (List<String>) tableService.getHistory().getActivities());
		map.put("tables", (List<Table>)tableService.getTables());
		return new ModelAndView("tableList", map);
	}
	
	@RequestMapping(value="/addTable/{tableName}")
	public String addTable(@PathVariable("tableName") String tableName) {
		tableService.addTable(new Table(tableName + " " + tableService.getTables().size(), TableVisibility.PRIVATE));
		
		if(logger.isDebugEnabled()){
			logger.debug("\"" + tableName + "\" board has been successfully added.");
		}
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value="/editTable/{index}", method = RequestMethod.GET)
	public String addTable(@PathVariable("index") int index) {
		tableService.editTable(index, "edytowana tablica");
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value="/deleteTable/{index}", method = RequestMethod.GET)
	public String deleteTable(@PathVariable("index") int index) {
		tableService.deleteTable(index);
		
		if(logger.isDebugEnabled()){
			logger.debug("Board no. " + index + " has been successfully deleted.");
		}
		return "redirect:/viewTables";
	}
	
	 @RequestMapping(value="/tablePage/{tableIndex}/{tableName}")
     public ModelAndView tablePage(Model model, @PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName) {
             Map<String, Object> map = new HashMap();
      		 map.put("history", (List<String>) tableService.getHistory().getActivities());
             map.put("lists", (List<TableList>)tableService.getTables().get(tableIndex).getLists());
             model.addAttribute("tableIndex", tableIndex);
             model.addAttribute("tableName", tableName);
             return new ModelAndView("tablePage", map);
     }
    
     @RequestMapping(value="/addList/{tableIndex}/{tableName}/{tableListName}", method = RequestMethod.GET)
     public String addList(@PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName, @PathVariable("tableListName") String tableListName) {
             tableService.addListToTable(tableIndex, new TableList(tableListName + " " + tableService.getTables().get(tableIndex).getLists().size()));
             return "redirect:/tablePage/" + tableIndex + "/" + tableName;
     }     
     
	@RequestMapping(value="/editList/{tableIndex}/{listIndex}/{newName}", method = RequestMethod.GET)
	public String editList(@PathVariable("tableIndex") int tableIndex,
							@PathVariable("listIndex") int listIndex,
							@PathVariable("newName") String newListName) {
		tableService.editList(tableIndex, listIndex, newListName);
		return "redirect:/tablePage/" + tableIndex;
	}
	
	@RequestMapping(value="/deleteList/{tableIndex}/{tableName}/{listIndex}", method = RequestMethod.GET)
	public String deleteList(@PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName, @PathVariable("listIndex") int listIndex) {
		tableService.deleteList(tableIndex, listIndex);
		return "redirect:/tablePage/" + tableIndex + "/" + tableName;
	}
	
	 @RequestMapping(value="/addCard/{tableIndex}/{tableName}/{listIndex}/{cardName}", method = RequestMethod.GET)
     public String addCard(@PathVariable("tableIndex") int tableIndex,
    		 			   @PathVariable("tableName") String tableName,
    		 			   @PathVariable("listIndex") int listIndex,
    		 			   @PathVariable("cardName") String cardName) {
          tableService.addCardToList(tableIndex, listIndex, new Card(cardName + " " + tableService.getTables().get(tableIndex).getLists().get(listIndex).getCards().size()));
          return "redirect:/tablePage/" + tableIndex + "/" + tableName;
     }
     
	 @RequestMapping(value="/editCard/{tableIndex}/{listIndex}/{cardIndex}/{newName}", method = RequestMethod.GET)
	 public String editCard(@PathVariable("tableIndex") int tableIndex,
							@PathVariable("listIndex") int listIndex,
							@PathVariable("cardIndex") int cardIndex,
							@PathVariable("newName") String newName) {
		 tableService.editCard(tableIndex, listIndex, cardIndex, newName);
		 return "redirect:/tablePage/" + tableIndex;
	 }
	
	 @RequestMapping(value="/deleteCard/{tableIndex}/{listIndex}/{cardIndex}/{tableName}", method = RequestMethod.GET)
	 public String deleteCard(@PathVariable("tableIndex") int tableIndex,
			 				  @PathVariable("listIndex") int listIndex,
			 				  @PathVariable("cardIndex") int cardIndex,
			 				  @PathVariable("tableName") String tableName) {
		 tableService.deleteCard(tableIndex, listIndex, cardIndex);
		 return "redirect:/tablePage/" + tableIndex + "/" + tableName;
	 }
	
	 @RequestMapping(value="/addComment/{tableIndex}/{tableName}/{listIndex}/{cardIndex}/{commentText}", method = RequestMethod.GET)
     public String addComment(@PathVariable("tableIndex") int tableIndex,
    		 			   @PathVariable("tableName") String tableName,
    		 			   @PathVariable("listIndex") int listIndex,
    		 			   @PathVariable("cardIndex") int cardIndex,
    		 			   @PathVariable("commentText") String commentText) {
          tableService.addComment(tableIndex, listIndex, cardIndex, commentText);
          return "redirect:/tablePage/" + tableIndex + "/" + tableName;
     }
     
	 @RequestMapping(value="/editComment/{tableIndex}/{listIndex}/{cardIndex}/{commentIndex}/{newName}", method = RequestMethod.GET)
	 public String editComment(@PathVariable("tableIndex") int tableIndex,
								@PathVariable("listIndex") int listIndex,
								@PathVariable("cardIndex") int cardIndex,
								@PathVariable("commentIndex") int commentIndex,
								@PathVariable("newName") String newName) {
		 tableService.editComment(tableIndex, listIndex, cardIndex, commentIndex, newName);
		 return "redirect:/tablePage/" + tableIndex;
	 }
	
	 @RequestMapping(value="/deleteComment/{tableIndex}/{listIndex}/{cardIndex}/{commentIndex}/{tableName}", method = RequestMethod.GET)
	 public String deleteComment(@PathVariable("tableIndex") int tableIndex,
				 				  @PathVariable("listIndex") int listIndex,
				 				  @PathVariable("cardIndex") int cardIndex,
				 				  @PathVariable("commentIndex") int commentIndex,
				 				  @PathVariable("tableName") String tableName) {
		 tableService.deleteComment(tableIndex, listIndex, cardIndex, commentIndex);
		 return "redirect:/tablePage/" + tableIndex + "/" + tableName;
	 }
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "hello world");
		
		return model;
	}
}

