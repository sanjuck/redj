var com_redjframework_test_web_ajax_WebController=AJC.extend({init:function() { this._super(); },list:function(){return this.afterReturning(this.before(arguments).action("href", "/ajax/list", arguments));},save:function(){return this.afterReturning(this.before(arguments).action("call", "/ajax/save", arguments));}});