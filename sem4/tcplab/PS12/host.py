import http.server
import socketserver

class MyHttpRequestHandler(http.server.SimpleHTTPRequestHandler):
    def  do_GET(self):
        if self.path == '/':
            self.path = 'register.html'
        return http.server.SimpleHTTPRequestHandler.do_GET(self)

handler_object = MyHttpRequestHandler

PORT = 8000
my_server = socketserver.TCPServer(("127.0.0.1", PORT), handler_object)
my_server.serve_forever()
