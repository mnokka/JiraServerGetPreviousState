// 2.3.2022 mika.nokka1@gmail.com 
//
// JiraServer(DC) postfunction to inform from which state this transit is done
// (can be used to store this information to hidden variable)


import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Logger
import org.apache.log4j.Level


// set logging to Jira log
def log = Logger.getLogger("PreviousStateLogger") 
log.setLevel(Level.INFO)  // DEBUG INFO
 
log.debug("---------- PreviousStateLogger started -----------")

def changeItem = ComponentAccessor.getChangeHistoryManager().getChangeItemsForField(issue, 'status')
def result= changeItem?.fromString
def size=changeItem.size()
def from=changeItem[size-1].fromString

log.debug("All previous states:${result}")
log.debug("State array size:${size}")
log.info("TRANSIT FROM STATE:${from}")
log.debug("---------- PreviousStateLogger ended -----------")